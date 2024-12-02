package ribeiro.silveira.vinicius.med.voll.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ribeiro.silveira.vinicius.med.voll.api.domain.endereco.Endereco;
import ribeiro.silveira.vinicius.med.voll.api.domain.endereco.EnderecoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.Especialidade;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.MedicoCadastroDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.MedicoDadosDetalhadoDTO;
import ribeiro.silveira.vinicius.med.voll.api.domain.medico.MedicoRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<MedicoCadastroDTO> medicoCadastroDTOJson;

    @Autowired
    private JacksonTester<MedicoDadosDetalhadoDTO> medicoDadosDetalhadoDTOJson;

    @MockBean
    private MedicoRepository repository;


    @Test
    @DisplayName("Deveria devolver erro http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {

        var response = mvc.perform(post("/medicos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {

        var dadosCadastro = new MedicoCadastroDTO("medico", "medico@voll.med", "123456", "61999999999",
                Especialidade.CARDIOLOGIA, enderecoDTO());

        var response = mvc.perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(medicoCadastroDTOJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new MedicoDadosDetalhadoDTO(
                null,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.crm(),
                dadosCadastro.telefone(),
                dadosCadastro.especialidade(),
                new Endereco(enderecoDTO())
        );

        var jsonEsperado = medicoDadosDetalhadoDTOJson.write(dadosDetalhamento).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

    }

    private EnderecoDTO enderecoDTO() {
        return new EnderecoDTO("rua",
                "bairro",
                "71000000",
                "cidade",
                "UF",
                "123",
                "complemento");
    }
}
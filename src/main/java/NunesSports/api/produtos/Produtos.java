package NunesSports.api.produtos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name="produtos")
@Entity(name="Produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer codigo;
    private String descricao;
    private BigDecimal preco;

    private Boolean ativo;

    public Produtos(DadosCadastroProdutos dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.codigo = dados.codigo();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoProdutos dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.codigo() != null){
            this.codigo = dados.codigo();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.preco() != null){
            this.preco = dados.preco();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

package NunesSports.api.produtos;

import java.math.BigDecimal;

public record DadosListagemProdutos(Long id, String nome, Integer codigo, String descricao, BigDecimal preco) {

    public DadosListagemProdutos(Produtos produtos){
        this(produtos.getId(), produtos.getNome(), produtos.getCodigo(),produtos.getDescricao(), produtos.getPreco());
    }
}

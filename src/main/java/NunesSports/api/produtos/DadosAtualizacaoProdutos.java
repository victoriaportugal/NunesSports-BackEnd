package NunesSports.api.produtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosAtualizacaoProdutos(
        @NotNull
        Long id,
        String nome,
        Integer codigo,
        String descricao,
        BigDecimal preco) {
}

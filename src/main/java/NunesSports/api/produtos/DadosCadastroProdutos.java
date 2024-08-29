package NunesSports.api.produtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProdutos(

        @NotBlank
        String nome,

        @NotNull
        Integer codigo,

        String descricao,

        @DecimalMin(value = "0.0", inclusive = true, message = "O preço deve ser maior ou igual a 0")
        BigDecimal preco) {
}


package NunesSports.api.controller;

import NunesSports.api.produtos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;



@RestController
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProdutos dados) {
            repository.save(new Produtos(dados));
        }

    @GetMapping
    public Page<DadosListagemProdutos> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProdutos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoProdutos dados) {
        var produtos = repository.getReferenceById(dados.id());
        produtos.atualizarInformacoes(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        var produtos = repository.getReferenceById(id);
        produtos.excluir();
    }

}
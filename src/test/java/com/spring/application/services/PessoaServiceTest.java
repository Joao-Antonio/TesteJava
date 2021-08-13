package com.spring.application.services;

import com.spring.application.domain.Pessoa;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Rule
    public ErrorCollector error = new ErrorCollector();

//    public void TesteBuscar(){
//        pessoaService.listarTodos(Long.valueOf(74));
//    }


//    public void TesteBuscarId(){
//        Pessoa pessoa = pessoaService.buscarId(Long.valueOf(74));
//        assertEquals(Long.valueOf(74), pessoa.getId());
//    }

    @Test
    public void buscarId() throws Exception {
        Pessoa pessoa = pessoaService.buscarId(Long.valueOf(74));

        Pessoa p2 = new Pessoa();
        String cpf = "09630012995";

        p2.setCpf(cpf);

        error.checkThat(pessoa.getId() , CoreMatchers.is(CoreMatchers.equalTo(74)));

//        Assert.assertSame(pessoa.getId(), p2.getCpf());
    }
}

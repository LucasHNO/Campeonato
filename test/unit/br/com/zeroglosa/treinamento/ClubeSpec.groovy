package br.com.zeroglosa.treinamento

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
class ClubeSpec extends Specification {

    void "Calcula saldo de gols utilizando a abordagem de gols feitos menos gols contra"() {
    given:
    Clube clube = new Clube(
            golsPro : golsPro,
            golsContra : golsContra
    )
    expect:
    clube.saldo == saldoEsperado

    where:
    golsPro | golsContra | saldoEsperado
       5    |     0      |       5
       0    |     5      |      -5
       5    |     5      |       0
    }
}

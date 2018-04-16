(ns medjay.loan-test
  (:use midje.sweet)
  (:use [medjay.loan]))

(facts "sucesso no pedido de empréstimo"
       (fact "quero tomar um empréstimo"
             (pickUp "66677788899" 1000) => "empréstimo liberado com sucesso.")
       (fact "quero saber se o valor que necessito está disponível para eu pegar emprestado"
             (availableInCash 1000) => true)
       (fact "quero saber se o meu nome não está negativado"
             (InDebt "66677788899") => false))

(facts "problemas na solicitação de empréstimo"
       (fact "quero tentar tomar um empréstimo num valor acima do permitido"
             (pickUp "66677788899" 1001) => "não liberamos o empréstimo desejado.")
       (fact "quero tentar tomar um empréstimo com um CPF negativado"
             (pickUp "12312312344" 1000) => "não liberamos o empréstimo desejado."))
(ns medjay.loan-test
  (:use midje.sweet)
  (:use [medjay.loan]))

(facts "Pedido de empréstimo com sucesso"
       (fact "quero tomar um empréstimo"
             (pickUp "66677788899" 1000 22) => "empréstimo liberado com sucesso.")
       (fact "quero saber se o valor que necessito está disponível"
             (availableInCash 1000) => true)
       (fact "quero saber se o meu nome não está negativado"
             (InDebt "66677788899") => false))

(facts "Pedido de empréstimo sem sucesso"
       (fact "quero tentar tomar um empréstimo num valor acima do permitido"
             (pickUp "66677788899" 1001 22) => "não liberamos o empréstimo desejado.")
       (fact "quero tentar tomar um empréstimo com um CPF negativado"
             (pickUp "12312312344" 1000 22) => "não liberamos o empréstimo desejado."))
      (fact "quero tentar tomar sendo menor de idade"
             (pickUp "66677788899" 1000 17) => "não liberamos o empréstimo desejado.")
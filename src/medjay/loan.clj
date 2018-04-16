(ns medjay.loan)

(defn availableInCash [value]
  (if (> value 1000) false true))

(defn InDebt [cpf]
  (if (= (compare cpf "12312312344") 0) true false))

(defn pickUp [cpf value]
  (if (and (not (InDebt cpf)) (availableInCash value)) "empréstimo liberado com sucesso." "não liberamos o empréstimo desejado."))

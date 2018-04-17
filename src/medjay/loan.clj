(ns medjay.loan)

(defn availableInCash [value]
  (if (> value 1000) false true))

(defn InDebt [cpf]
  (if (= (compare cpf "12312312344") 0) true false))

(defn isMinor [age]
  (if (> age 18) false true))

(defn pickUp [cpf value age]
  (if (and (not (InDebt cpf)) (availableInCash value) (not (isMinor age)) ) "empréstimo liberado com sucesso." "não liberamos o empréstimo desejado."))

# Experiments

_Hallo wie geht's!?_ </br> </br>
Olá, como que vai!?

O projeto **Experiments** como o próprio nome sugere, é um lugar para se aventurar e se divertir com tecnologias que rodeiam o desenvolvimento de um aplicativo. Foi feito pensando em facilitar o uso de toda e qualquer **_api_**, e portanto não possui de fato um único contexto de desenvolvimento, sendo o contexto inicial sobre clima-tempo e utiliza da api [Open Weather api](https://openweathermap.org/api).

---

### Detalhes do projeto

- Desenvolvido majoritariamente em kotlin
- Segue Clean Architecture e MVVM
- Kotlin Flow para single shot operations
- Pre-commit hook para uso de _ktlint_ e _detekt_
- Branch com adição de flipper
- Testes unitários para as camadas de **data**, **domain**, **presentation**
- Compose para UI
- Utiliza variáveis de ambiente para guardar informações como chaves de api
- Segue a idéia de separação de módulos em **public** e **implementation**
- Koin para injeção de dependência
  
---

### Tela Inicial

A tela inicial do app visa mostrar informações sobre clima-tempo:

![image](https://github.com/gabrielestrela/Experiments/assets/11582442/ce3830f4-06a2-4378-b3c7-4c9afc8abbbe)

---
### Notas

> :warning: O projeto foi criado utilizando **Android Studio Hedgehog**, e portanto pode apresentar problemas ao rodar 😿 

#### Adicionar ao arquivo ~/.zshrc ou ~/.bashrc

```shell

   export WEATHER_API="{token}"

```

# DAT108

> Obligatorisk innlevering 3

Levert av:

* Arne Olai Molland
* Sondre Gjellestad
* Anders Graneng

## Viktig info om prosjektet

Prosjektet er bygget med **gradle** + **gretty** & **war**. For sanitering av input har vi brukt **jsoup**.

Eclipse har som standard innebygget buildship plugin for gradle. For å kjøre prosjektet,

importer som gradle-prosjekt, naviger til 'Gradle Tasks' og kjør 'appRun' som ligger under

 'gretty'. Naviger så til *localhost:8080/oblig2*. **Obs!** <u>Vi har valgt å bruke JSP for å gjøre ting enklere.</u>

Eller, hvis du er hipster nok, kan du bruke cli-verktøyene til gradle. Da kan du navigere til roten av prosjektet

og kjøre *`./gradlew appRun`* i *terminal* (*`.\gradlew appRun`* i *cmd*/*powershell*), så er du **good to go**.

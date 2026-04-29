
## Estructura principal

app/src/main/java/com/example/android_studio_test_exercice/view/MainView.kt
app/src/main/java/com/example/android_studio_test_exercice/viewmodel/MainViewModel.kt
app/src/test/java/com/example/android_studio_test_exercice/ExampleUnitTest.kt
app/src/androidTest/java/com/example/android_studio_test_exercice/ExampleInstrumentedTest.kt

## Implementación MVVM

Se han completado todos los TODO que venían en el proyecto, respetando la estructura y el flujo original.

MainViewModel

Aquí se gestionan los estados y la lógica de:

Switch de Wi-Fi
Checkboxes del menú
Radio buttons
Slider
Dropdown
Campo de búsqueda (TextField)
Botón toggle final
MainView

Todos los componentes están conectados al ViewModel
Se usan estados con observeAsState(...)
Se han añadido testTag(...) para facilitar los tests de UI


Unit Testing

Archivo: ExampleUnitTest.kt

Se han testeado los métodos del MainViewModel, como:

toggleEstatSwitch
toggleEsCarnivor
toggleEsVegetaria
toggleEsVega
setSelectedOption
setSliderValue
setExpanded
setSelectedItem
setSearchText
performSearch
toggle

También se comprueba el estado inicial.

## Instrumental UI Testing

Archivo: ExampleInstrumentedTest.kt

Se han implementado tests para:

Comprobar el contexto de la app
Validar el estado inicial de la UI
Interacción con switch y checkboxes
Selección de radio buttons
Uso del slider y verificación del valor
Flujo del dropdown + búsqueda
Cambio de estado del botón toggle

## Evidencias


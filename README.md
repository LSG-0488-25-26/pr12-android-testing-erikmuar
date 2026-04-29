
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
Example unit test 12 test passed.

<img width="1906" height="1069" alt="image" src="https://github.com/user-attachments/assets/0c7249df-8187-44b4-beed-6f4d359177aa" />

Example instrumented test 8 tests passed.

<img width="1919" height="1078" alt="image" src="https://github.com/user-attachments/assets/b0be4614-8b36-4948-bfc6-c4c8d8ec5e0e" />

Link video: https://youtu.be/XWh4t2ATF80

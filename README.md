# amoviles-android-kotlin-g12
Curso de Aplicaciones Android con Kotlin G12(Básico - Intermedio- Avanzado) - Academia Móviles 


## Kotlin Fundamentals

Slides :

- Lesson3-UI https://docs.google.com/presentation/d/19mzDJ2zvdz36uvwM3Pc_Ep0Y5V6_XxE0D6iL7CBv3NA/edit?usp=sharing

Lesson https://github.com/emedinaa/amoviles-android-kotlin-g12/archive/L4-UIEvents.zip

## UI

Eventos 

```kotlin
  private fun showMessage(msg: String?) {
      Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
  }
  btn.setOnClickListener {
      showMessage("Click")
  }
```

Eventos de Teclado

```kotlin
eteUsername.addTextChangedListener(object : TextWatcher {
          override fun afterTextChanged(s: Editable?) {
              Log.v("CONSOLE", "afterTextChanged ${s.toString()}")
          }

          override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
              Log.v("CONSOLE", "beforeTextChanged ${s.toString()}")
          }

          override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
              Log.v("CONSOLE", "onTextChanged ${s.toString()}")
          }

})

etePassword.setOnEditorActionListener { _, actionId, event ->
            if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                send()
            }
            false
}
```
Eventos de Selección

```kotlin
spLocation.onItemSelectedListener= object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                location= adapterView?.adapter?.getItem(i).toString()
                showMessage("Item selected i : $i  value : $location")
            }
}
```

# References

- Android Jetpack https://developer.android.com/jetpack/?hl=es-419

- User Interface & Navigation https://developer.android.com/guide/topics/ui/declaring-layout?hl=es-419

- Device compatibility https://developer.android.com/guide/practices/compatibility

- User Interface & Navigation https://developer.android.com/guide/topics/ui/

- Layouts https://developer.android.com/guide/topics/ui/declaring-layout

- ConstraintLayout https://developer.android.com/reference/android/support/constraint/ConstraintLayout

- ConstraintLayout 1.1 https://medium.com/google-developers/introducing-constraint-layout-1-1-d07fc02406bc

- Understanding the performance benefits of ConstraintLayout  https://android-developers.googleblog.com/2017/08/understanding-performance-benefits-of.html

- CodeLab ConstraintLayout https://codelabs.developers.google.com/codelabs/constraint-layout/

- Layouts https://developer.android.com/guide/topics/ui/declaring-layout.html

- User Interface https://developer.android.com/guide/topics/ui/index.html

- Layout Editor https://developer.android.com/studio/write/layout-editor.html

- LinearLayout https://developer.android.com/guide/topics/ui/layout/linear.html

- RelativeLayout https://developer.android.com/guide/topics/ui/layout/relative.html

- ConstraintLayout https://developer.android.com/training/constraint-layout/index.html

- Recursos de diseño https://www.uplabs.com/

- Iconos https://www.iconfinder.com/

- Android Inspired UI http://android.inspired-ui.com/

- Drawable Resources https://developer.android.com/guide/topics/resources/drawable-resource.html

- Device compatibility https://developer.android.com/guide/practices/compatibility

- Material colors https://www.materialui.co/colors

- Touch & input https://developer.android.com/guide/input/

- User Events https://developer.android.com/guide/topics/ui/ui-events.html

# amoviles-android-kotlin-g12
Curso de Aplicaciones Android con Kotlin G12(Básico - Intermedio- Avanzado) - Academia Móviles 


## Kotlin RecyclerView & Adapters

Slides :

List&Adapters https://docs.google.com/presentation/d/1aA6tzgdWVRNcv-PXYxFY47jdaJLQpt5LVMZuxmj4gdY/edit?usp=sharing

RecyclerView https://docs.google.com/presentation/d/13bbzEcgmTos_TQXAf9tTm4LdGw9_8gHgVLF9JlCIWrI/edit?usp=sharing

Activities https://docs.google.com/presentation/d/1uhTfdRihh-LUa-Id541RM8FdhiC23XUEiyGTA1gTUTY/edit?usp=sharing

Lesson https://github.com/emedinaa/amoviles-android-kotlin-g12/archive/L5-RecyclerViewAdapters.zip

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

Diálogos

Invocar un dialog

```kotlin
btnDialog.setOnClickListener {
    showSimpleDialog()
}

private fun showSimpleDialog() {
    val dialog = SimpleDialog()
    dialog.show(supportFragmentManager, "SimpleDialog")
}
```

SimpleDialog

```kotlin
class SimpleDialog:DialogFragment() {

    private lateinit var mContext:Context

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(mContext)

        builder.setTitle("Aviso !")
            .setMessage(R.string.dialog_fire_missiles)
            .setPositiveButton(R.string.fire) { _, _ ->
                log("Dialog aceptar")
            }
            .setNegativeButton(R.string.scancel){ _, _ ->
                log("Dialog cancelar")
            }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }

    private fun log(message: String) {
        Log.d("CONSOLE", message)
    }
}
```

# References

- Adapter https://developer.android.com/reference/android/widget/Adapter.html

- ListView https://developer.android.com/guide/topics/ui/layout/listview.html

- GridView https://developer.android.com/guide/topics/ui/layout/gridview.html

- RecyclerView https://developer.android.com/guide/topics/ui/layout/recyclerview.html

- Creating List and Cards https://developer.android.com/training/material/lists-cards.html

- RecyclerView https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html

- Android Developers Fundamentals Course - Create a RecyclerView https://google-developer-training.gitbooks.io/android-developer-fundamentals-course-practicals/content/en/Unit%202/44_p_create_a_recycler_view.html

- RecyclerView samples https://github.com/emedinaa/android-recyclerview-and-adapters

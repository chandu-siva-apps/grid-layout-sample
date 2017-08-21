package io.cs.grid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    listOf(cardA, cardB, cardC, cardD, cardE, cardF).forEach { card ->
      card.setOnClickListener {
        val message = "You clicked on ${card.text}"
        Log.d("card.onclick", message)
        showToast(message)
      }
    }
  }

  private val toasts = arrayListOf<Toast>()
  private fun showToast(message: CharSequence) {
    Log.d("showToast", toasts.toString())
    if (toasts.isEmpty()) {
      val toast = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
      toast.show()
      toasts += toast
    } else {
      val toast = toasts.removeAt(0)
      if (toast == null) {
        showToast(message)
      } else {
        toast.setText(message)
        toast.show()
      }
    }
  }
}

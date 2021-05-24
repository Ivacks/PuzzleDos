package com.example.slidepuzzle

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.tomar_foto.*
import java.util.jar.Manifest

class HacerFoto  : AppCompatActivity() {

    private lateinit var cameraBtn: Button
    private lateinit var myImage: ImageView
    private val REQUEST_CAMERA = 1002

    var foto: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tomar_foto)
        abreCamara_Click()
    }

    private fun abreCamara_Click(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                val permisosCamara = arrayOf(android.Manifest.permission.CAMERA,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                requestPermissions(permisosCamara,REQUEST_CAMERA)
            } else {
                abreCamara()
            }
        } else {
            abreCamara()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_CAMERA -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    abreCamara()
                else Toast.makeText(applicationContext, "no se puede acceder a la camara", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun abreCamara() {
        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE, "yyyyMMdd_HHmmss")
        foto = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, value)
        val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, foto)
        startActivityForResult(camaraIntent, REQUEST_CAMERA)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CAMERA) {
            imgFoto.setImageURI(foto)
        }
    }
}


/*       botoFerFoto.setOnClickListener{
           val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
           if (takePictureIntent.resolveActivity(this.packageManager) != null) {
               startActivityForResult(takePictureIntent, REQUEST_CODE)
           } else {
               Toast.makeText(this, "no hem pogut obrir la camara", Toast.LENGTH_SHORT).show()
           }
       }
   }

   // esta parte se activa si la foto se ha realizado correctamente y almacena la imagen
   override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
           val fotoFeta = data?.extras?.get("data") as Bitmap
           imageFoto.setImageBitmap(fotoFeta)
          // guardarImagen()
       }

       super.onActivityResult(requestCode, resultCode, data)
  }

public fun guardarImagen(){
val externalStorageState = Environment.getExternalStorageState()
if (externalStorageState.equals(Environment.MEDIA_MOUNTED)){
    val storageDirectory = Environment.getExternalStorageDirectory().toString()
    val file = File(storageDirectory, "imatge_01.jpg")
        val stream:OutputStream = FileOutputStream(file)
        var drawable = ContextCompat.getDrawable(applicationContext, R.drawable.one);
        var bitmap = (drawable as BitmapDrawable).bitmap
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        stream.flush()
        stream.close()
        Toast.makeText(this, "imagen guardada correctamente ${Uri.parse(file.absolutePath)}", Toast.LENGTH_SHORT).show()
}

}


<uses-feature android:name="android.hardware.camera" android:required="true" />
<permission android:name="android.Manifest.permission.ACCESS_FINE_LOCATION" />

*/

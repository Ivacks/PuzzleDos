package com.example.slidepuzzle


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

abstract class FirebaseUIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.galeria)
    }

    fun loadWithGlide() {
        // [START storage_load_with_glide]
        // Reference to an image file in Cloud Storage
        val storageReference = Firebase.storage.reference

        // ImageView in your Activity
        val imageView = findViewById<ImageView>(R.id.ed_image)

        // Download directly from StorageReference using Glide
        // (See MyAppGlideModule for Loader registration)
        Glide.with(this /* context */)
            .load("https://firebasestorage.googleapis.com/v0/b/puzzledos.appspot.com/o/alien.jpg?alt=media&token=d703159b-3ac0-4d85-9d60-ea7aa5752119")
            .into(imageView)
        // [END storage_load_with_glide]
    }
}
/*
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import com.google.firebase.ktx.Firebase
import com.google.firebase.referencecode.storage.R
import com.google.firebase.storage.ktx.storage

class Storage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.slidepuzzle.R.layout.galeria)}
    fun loadWithGlide() {
        val imageView = findViewById<ImageView>(R.id.ed_image)

        Glide.with(this)
            .load("https://www.adslzone.net/app/uploads-adslzone.net/2019/04/borrar-fondo-imagen-930x487.jpg")
            .into(imageView)

    }}
*/

// class Gallery : AppCompatActivity() {
//
// lateinit  var storage: FirebaseStorage
//
// override fun onCreate(savedInstanceState: Bundle?) {
// super.onCreate(savedInstanceState)
// setContentView(R.layout.galeria)
//
// storage = Firebase.storage
// includesForCreateReference()
// }
// private fun includesForCreateReference() {
// val storage = Firebase.storage
//
// // ## Create a Reference
//
// // [START create_storage_reference]
// // Create a storage reference from our app
// var storageRef = storage.reference
// // [END create_storage_reference]
//
// // [START create_child_reference]
// // Create a child reference
// // imagesRef now points to "images"
// var imagesRef: StorageReference? = storageRef.child("gs://puzzledos.appspot.com")
//
// // Child references can also take paths
// // spaceRef now points to "images/space.jpg
// // imagesRef still points to "images"
// var spaceRef = storageRef.child("gs://puzzledos.appspot.com/alien.jpg")
// // [END create_child_reference]
// imagesRef = spaceRef.parent
//
// val rootRef = spaceRef.root
// // [END navigate_references]
//
// // [START chain_navigation]
// // References can be chained together multiple times
// // earthRef points to 'images/earth.jpg'
// val earthRef = spaceRef.parent?.child("alien.jpg")
// }
//
// fun includesForUploadFiles() {
// val storage = Firebase.storage
//
// // [START upload_create_reference]
// // Create a storage reference from our app
// val storageRef = storage.reference
//
// // Create a reference to "mountains.jpg"
// val alienRef = storageRef.child("alien.jpg")
//
// // Create a reference to 'images/mountains.jpg'
// val alienImageRef = storageRef.child("gs://puzzledos.appspot.com/alien.jpg")
//
// // While the file names are the same, the references point to different files
// alienRef.name == alienImageRef.name // true
// alienRef.path == alienImageRef.path // false
// // [END upload_create_reference]
//
// // [START upload_memory]
// // Get the data from an ImageView as bytes
// imageView.isDrawingCacheEnabled = true
// imageView.buildDrawingCache()
// val bitmap = (imageView.drawable as BitmapDrawable).bitmap
// val baos = ByteArrayOutputStream()
// bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
// val data = baos.toByteArray()
//
// var uploadTask = alienRef.putBytes(data)
// uploadTask.addOnFailureListener {
// // Handle unsuccessful uploads
// }.addOnSuccessListener { taskSnapshot ->
// // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
// // ...
// }
//
//
// /* lateinit var imageView: ImageView
// lateinit var button: Button
// private val pickImage = 100
// private var imageUri: Uri? = null
// override fun onCreate(savedInstanceState: Bundle?) {
// super.onCreate(savedInstanceState)
// setContentView(R.layout.galeria)
//
// title = "KotlinApp"
// imageView = findViewById(R.id.imageView)
// button = findViewById(R.id.buttonLoadPicture)
// button.setOnClickListener {
// val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
// startActivityForResult(gallery, pickImage)
// }
// }
// override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
// super.onActivityResult(requestCode, resultCode, data)
// if (resultCode == RESULT_OK && requestCode == pickImage) {
// imageUri = data?.data
// imageView.setImageURI(imageUri)
// GameActivity.initialConfig = BoardActivityParams(
// MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri),
// BoardTitledSize(3,3)
//
// )
// startActivity(
// Intent(this, GameActivity::class.java)
// )
// }
// } */
// }}
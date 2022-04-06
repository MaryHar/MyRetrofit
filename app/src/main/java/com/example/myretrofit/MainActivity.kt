package com.example.myretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val responseText = findViewById<View>(R.id.text) as TextView
        val apiInterface = APIClient().getClient()?.create<APIInterface>(APIInterface::class.java)

        val call: Call<MultipleResource?>? = apiInterface!!.doGetListResources()
        call?.enqueue(object : Callback<MultipleResource?> {
            override fun onResponse(
                call: Call<MultipleResource?>?,
                response: Response<MultipleResource?>
            ) {
                Log.d("TAG", response.code().toString() + "")
                var displayResponse = ""
                val resource: MultipleResource? = response.body()
                val text = resource?.page
                val total = resource?.total
                val totalPages = resource?.totalPages
                val dataList = resource?.data
                displayResponse += """${text.toString()} Page
$total Total
$totalPages Total Pages

"""
                for (data in dataList!!) {
                    displayResponse += """ id = ${data.id.toString()} email = ${data.email} name = ${data.firstName} last name = ${data.lastName} avatar = ${data.avatar}
                        
"""
                }
                responseText.text = displayResponse
            }

            override fun onFailure(call: Call<MultipleResource?>, t: Throwable?) {
                call.cancel()
            }
        })

    }
}
package tw.edu.pu.s1114859.firebase_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FoundationDetailsActivity : AppCompatActivity() {
    private lateinit var tvFdName: TextView
    private lateinit var tvFdPhone: TextView
    private lateinit var tvFdFax: TextView
    private lateinit var tvFdMail: TextView
    private lateinit var tvFdAddress: TextView
    private lateinit var tvFdDistrict: TextView
    private lateinit var tvFdLink: TextView
    private lateinit var tvFdUpdated: TextView
    private lateinit var tvFdOb: TextView
    private lateinit var tvFdCategory: TextView
    private lateinit var tvFdAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foundation_details)

        initView()
        setValuesToViews()

    }

    private fun initView() {
        tvFdName = findViewById(R.id.dataname)
        tvFdPhone = findViewById(R.id.dataphone)
        tvFdFax = findViewById(R.id.datafax)
        tvFdMail = findViewById(R.id.datamail)
        tvFdAddress = findViewById(R.id.dataddress)
        tvFdDistrict = findViewById(R.id.datarea)
        tvFdLink = findViewById(R.id.datalink)
        tvFdUpdated = findViewById(R.id.dataupdated)
        tvFdOb = findViewById(R.id.dataob)
        tvFdCategory = findViewById(R.id.datacategory)
        tvFdAge = findViewById(R.id.datage)
    }

    private fun setValuesToViews() {
        tvFdName.text = intent.getStringExtra("fdName")
        tvFdPhone.text = intent.getStringExtra("fdPhone")
        tvFdFax.text = intent.getStringExtra("fdFax")
        tvFdMail.text = intent.getStringExtra("fdMail")
        tvFdAddress.text = intent.getStringExtra("fdAddress")
        tvFdDistrict.text = intent.getStringExtra("fdDistrict")
        tvFdLink.text = intent.getStringExtra("fdLink")
        tvFdUpdated.text = intent.getStringExtra("fdUpdated")
        tvFdOb.text = intent.getStringExtra("fdOb")
        tvFdCategory.text = intent.getStringExtra("fdCategory")
        tvFdAge.text = intent.getStringExtra("fdAge")



    }
}

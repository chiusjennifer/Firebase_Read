package tw.edu.pu.s1114859.firebase_crud

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class FetchingActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var fdList: ArrayList<FoundationModel>
    private lateinit var dbRef: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetching)

        mRecyclerView = findViewById(R.id.rvFd)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.setHasFixedSize(true)

        fdList = arrayListOf<FoundationModel>()

        getFdData()

    }

    private fun getFdData() {

        dbRef = FirebaseDatabase.getInstance().getReference("TC_opendata")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                fdList.clear()
                if (snapshot.exists()){
                    for (fdSnap in snapshot.children){
                        val fdData = fdSnap.getValue(FoundationModel::class.java)
                        fdList.add(fdData!!)
                    }
                    val mAdapter = FdAdapter(fdList)
                    mRecyclerView.adapter = mAdapter

                    mAdapter.setOnItemClickListener(object : FdAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {

                            val intent = Intent(this@FetchingActivity, FoundationDetailsActivity::class.java)

                            //put extras
                            intent.putExtra("fdName", fdList[position].fdname)
                            intent.putExtra("fdPhone", fdList[position].fdphone)
                            intent.putExtra("fdFax", fdList[position].fdfax)
                            intent.putExtra("fdMail", fdList[position].fdmail)
                            intent.putExtra("fdAddress", fdList[position].fdaddress)
                            intent.putExtra("fdDistrict", fdList[position].fdistrict)
                            intent.putExtra("fdLink", fdList[position].fdlink)
                            intent.putExtra("fdUpdated", fdList[position].fdupdated)
                            intent.putExtra("fdOb", fdList[position].fdob)
                            intent.putExtra("fdCategory", fdList[position].fdcategory)
                            intent.putExtra("fdAge", fdList[position].fdage)
                            startActivity(intent)
                        }

                    })
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
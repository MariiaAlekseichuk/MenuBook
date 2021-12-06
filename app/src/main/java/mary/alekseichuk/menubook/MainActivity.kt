package mary.alekseichuk.menubook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout

    private lateinit var sentUserNameButton: Button
    private lateinit var userName: TextView
    private lateinit var ediTextField: EditText

    private val userNameKey = "USER_NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(PizzasFragment(), "Pizzas")
        adapter.addFragment(LunchesFragment(), "Lunches")
        adapter.addFragment(DesertsFragment(), "Deserts")

        // adding the Adapter to the ViewPager
        pager.adapter = adapter
        // bind the viewPager with the TabLayout
        tab.setupWithViewPager(pager)

        setUserName(savedInstanceState)
    }

    private fun setUserName(savedInstanceState: Bundle?) {
        sentUserNameButton = findViewById(R.id.send_name_button)
        userName = findViewById(R.id.userName)
        ediTextField = findViewById(R.id.ediTextField)

        if (savedInstanceState != null) {
            userName.text = savedInstanceState.getString(userNameKey)
        }
        sentUserNameButton.setOnClickListener {
            userName.text = ediTextField.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(userNameKey, userName.text.toString())
        }
        super.onSaveInstanceState(outState)
    }


}
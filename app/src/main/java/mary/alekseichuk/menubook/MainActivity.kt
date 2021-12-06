package mary.alekseichuk.menubook

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout

    private lateinit var sentUserNameButton: Button
    private lateinit var userName: TextView
    private lateinit var ediTextField: EditText
    private lateinit var sendEmailButton: Button

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
        sendEmailClick()
    }

    private fun sendEmailClick() {
        sendEmailButton = findViewById(R.id.sendEmail)
        val emailIntent = Intent(Intent.ACTION_SENDTO)
        sendEmailButton.setOnClickListener {
            emailIntent.apply {
                type = "text/plain"
                data = Uri.parse("mailto:") // only email apps should handle this
                putExtra(Intent.EXTRA_EMAIL, "support@menubook.com")
                putExtra(Intent.EXTRA_SUBJECT, "My Question")
                putExtra(Intent.EXTRA_TEXT, "Body Here");
            }
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            } else Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT)
                .show();
        }
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
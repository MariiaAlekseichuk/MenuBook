package mary.alekseichuk.menubook

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout

const val USER_NAME_KEY = "USER_NAME"
class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var topAppBar: MaterialToolbar
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        topAppBar = findViewById(R.id.topAppBar)
        if (savedInstanceState != null) {
            topAppBar.title = savedInstanceState.getString(USER_NAME_KEY)
        }
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(PizzasFragment(), "Pizzas")
        adapter.addFragment(LunchesFragment(), "Lunches")
        adapter.addFragment(DesertsFragment(), "Deserts")

        // adding the Adapter to the ViewPager
        pager.adapter = adapter
        // bind the viewPager with the TabLayout
        tab.setupWithViewPager(pager)

        //setUserName(savedInstanceState)
        sendEmailClick()

    }


    private fun sendEmailClick() {

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.sendEmail -> {
                    val emailIntent = Intent(Intent.ACTION_SENDTO)
                    emailIntent.apply {
                        type = "text/plain"
                        data = Uri.parse("mailto:") // only email apps should handle this
                        putExtra(Intent.EXTRA_EMAIL, "support@menubook.com")
                        putExtra(Intent.EXTRA_SUBJECT, "My Question")
                        putExtra(Intent.EXTRA_TEXT, "Body Here");
                    }
                    if (emailIntent.resolveActivity(packageManager) != null) {
                        startActivity(Intent.createChooser(emailIntent, "Send mail..."))
                    } else Toast.makeText(
                        this,
                        "There is no email client installed.",
                        Toast.LENGTH_SHORT
                    )
                        .show();

                    true
                }
                R.id.setUserNameMenuButton -> {
                    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                    builder.setTitle("Enter your name here")
                    val input = EditText(this)
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                    input.inputType = InputType.TYPE_CLASS_TEXT
                    builder.setView(input)
                    builder.setPositiveButton(
                        "OK"
                    ) { dialog, which ->
                        userName = input.text.toString()
                        topAppBar.title = "Hello, $userName!"
                    }
                    builder.setNegativeButton(
                        "Cancel"
                    ) { dialog, which -> dialog.cancel() }

                    builder.show()
                    true
                }

                else -> false
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString(USER_NAME_KEY, topAppBar.title.toString())
        }
        super.onSaveInstanceState(outState)
    }


}
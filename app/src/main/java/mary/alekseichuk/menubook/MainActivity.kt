package mary.alekseichuk.menubook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import mary.alekseichuk.menubook.meallist.Meal
import mary.alekseichuk.menubook.meallist.MealAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout

    lateinit var pizzasRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(PizzasFragment(), "Pizzas")
        adapter.addFragment(LunchesFragment(), "Lunches")
        adapter.addFragment(DesertsFragment(), "Deserts")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter
        //bind the viewPager with the TabLayout
        tab.setupWithViewPager(pager)


    }


}
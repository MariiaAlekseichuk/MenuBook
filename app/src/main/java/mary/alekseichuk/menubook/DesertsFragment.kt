package mary.alekseichuk.menubook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mary.alekseichuk.menubook.meallist.Meal
import mary.alekseichuk.menubook.meallist.MealAdapter

class DesertsFragment : Fragment() {

    private lateinit var desertsRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val desertList: List<Meal> = setDesertList()
        val desertLayout = R.layout.fragment_deserts
        val desertsRecyclerViewId = R.id.deserts_recycler_view

        val inflate = inflater.inflate(desertLayout, container, false)!!

        desertsRecyclerView = inflate.findViewById(desertsRecyclerViewId)
        desertsRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        desertsRecyclerView.adapter = MealAdapter(desertList)
        desertsRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        return inflate
    }

    private fun setDesertList(): List<Meal> {
        return listOf(
            Meal("Cheese Cake", 20),
            Meal("Napoleon", 19),
            Meal("Ice Cream", 21),
            Meal("Chocolate Cake", 18),
            Meal("Muffin", 18),
            Meal("Pudding", 18)
        )
    }
}

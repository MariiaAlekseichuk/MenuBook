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

class PizzasFragment : Fragment() {

    private lateinit var pizzasRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val pizzaList: List<Meal> = setPizzaList()
        val pizzaLayout = R.layout.fragment_pizza
        val pizzasRecyclerViewId = R.id.pizzas_recycler_view

        val inflate = inflater.inflate(pizzaLayout, container, false)!!

        pizzasRecyclerView = inflate.findViewById(pizzasRecyclerViewId)
        pizzasRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        pizzasRecyclerView.adapter = MealAdapter(pizzaList)
        pizzasRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        return inflate
    }

    private fun setPizzaList(): List<Meal> {
        return listOf(
            Meal("Margarita", 20),
            Meal("Pepperoni", 19),
            Meal("Double Cheese", 21),
            Meal("Hawaiian", 18)
        )
    }

}
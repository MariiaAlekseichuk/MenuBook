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


class LunchesFragment : Fragment() {

    private lateinit var lunchRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val lunchList: List<Meal> = setLunchList()
        val lunchLayout = R.layout.fragment_lunches
        val lunchesRecyclerViewId = R.id.lunches_recycler_view

        val inflate = inflater.inflate(lunchLayout, container, false)!!

        lunchRecyclerView = inflate.findViewById(lunchesRecyclerViewId)

        lunchRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        lunchRecyclerView.adapter = MealAdapter(lunchList)
        lunchRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )

        return inflate
    }

    private fun setLunchList(): List<Meal> {
        return listOf(
            Meal("Business Lunch", 100),
            Meal("Homemade Lunch", 180),
            Meal("Double Lunch", 210),
        )
    }
}
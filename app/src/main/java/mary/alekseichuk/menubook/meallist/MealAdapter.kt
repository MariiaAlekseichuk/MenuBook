package mary.alekseichuk.menubook.meallist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mary.alekseichuk.menubook.R

class MealAdapter(private val mealList: List<Meal>) : RecyclerView.Adapter<MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.meal_list_item, parent, false)
        return MealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = mealList[position]
        holder.bind(meal)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }
}
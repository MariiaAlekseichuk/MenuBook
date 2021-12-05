package mary.alekseichuk.menubook.meallist

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import mary.alekseichuk.menubook.R

class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
    private val priceTextView: TextView = itemView.findViewById(R.id.price_text_view)

    fun bind(meal: Meal) {
        nameTextView.text = "${meal.name}"
        priceTextView.text = "${meal.price}"

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, meal.name, Toast.LENGTH_LONG).show()
        }

    }
}
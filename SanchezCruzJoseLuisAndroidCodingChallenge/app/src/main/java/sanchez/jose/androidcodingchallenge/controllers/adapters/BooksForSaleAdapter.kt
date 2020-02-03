package sanchez.jose.androidcodingchallenge.controllers.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book_for_sale.view.*
import sanchez.jose.androidcodingchallenge.models.BookViewModel
import sanchez.jose.androidcodingchallenge.R

class BooksForSaleAdapter(): RecyclerView.Adapter<BookForSaleViewHolder>() {

    private var booksForSale = mutableListOf<BookViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookForSaleViewHolder {
        return BookForSaleViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_book_for_sale, parent, false))
    }

    override fun getItemCount() = booksForSale.size

    override fun onBindViewHolder(holder: BookForSaleViewHolder, position: Int) {
        booksForSale[position].let {
            holder.itemView.title.text = it.title
            holder.itemView.author.text = it.author
            if (it.image.isNotEmpty()) {
                Picasso.get().load(it.image).into(holder.itemView.image)
            }
        }
    }

    public fun update(data: List<BookViewModel>) {
        booksForSale.clear()
        booksForSale.addAll(data)
        notifyDataSetChanged() // Expensive to call it every time, maybe notifyItemChanged?
    }
}
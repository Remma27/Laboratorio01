package com.example.laboratorio01
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class EventAdapter(private val events: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val eventName: TextView = itemView.findViewById(R.id.eventName)
        val eventDate: TextView = itemView.findViewById(R.id.eventDate)
        val eventDescription: TextView = itemView.findViewById(R.id.eventDescription)
        val eventLocation: TextView = itemView.findViewById(R.id.eventLocation)
        val eventExpositor: TextView = itemView.findViewById(R.id.eventExpositor)
        val eventBackground: ImageView = itemView.findViewById(R.id.eventBackground)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_card, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentEvent = events[position]
        holder.eventName.text = currentEvent.name
        holder.eventDate.text = currentEvent.date
        holder.eventDescription.text = currentEvent.description
        holder.eventLocation.text = currentEvent.location
        holder.eventExpositor.text = currentEvent.expositor
        holder.itemView.setOnClickListener {

        }
        val context = holder.itemView.context
        val imageResId = when (position % 6) {
            0 -> R.drawable.background1
            1 -> R.drawable.background2
            2 -> R.drawable.background3
            3 -> R.drawable.background4
            4 -> R.drawable.background5
            5 -> R.drawable.background6
            else -> R.drawable.background0
        }
        holder.eventBackground.setImageResource(imageResId)
        holder.itemView.alpha = 0.8f
        holder.eventBackground.scaleType = ImageView.ScaleType.CENTER_CROP

        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount() = events.size
}
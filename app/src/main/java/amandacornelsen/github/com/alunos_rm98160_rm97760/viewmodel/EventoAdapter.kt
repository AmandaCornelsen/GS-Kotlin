package amandacornelsen.github.com.alunos_rm98160_rm97760

import amandacornelsen.github.com.alunos_rm98160_rm97760.model.Evento
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventoAdapter(
    private val listaEventos: MutableList<Evento>,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeLocal: TextView = itemView.findViewById(R.id.nomeLocal)
        val impacto: TextView = itemView.findViewById(R.id.impacto)
        val pessoas: TextView = itemView.findViewById(R.id.pessoas)
        val data: TextView = itemView.findViewById(R.id.data)
        val tipoDeEvento: TextView = itemView.findViewById(R.id.tipoEvento)
        val btnDelete: ImageView = itemView.findViewById(R.id.deletar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = listaEventos[position]
        holder.nomeLocal.text = "Local do evento: ${evento.nomeLocal}"
        holder.impacto.text = "Nível de Impacto: ${evento.impacto}"
        holder.pessoas.text = "Pessoas Afetadas: ${evento.numeroPessoas}"
        holder.data.text = "Data do evento: ${evento.data}"
        holder.tipoDeEvento.text = "Tipo de Evento: ${evento.tipoEvento}"

        holder.btnDelete.setOnClickListener {
            onDeleteClick(position)
        }
    }

    override fun getItemCount() = listaEventos.size
}
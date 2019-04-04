package hu.bme.coctailexample.ui.coctails

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hu.bme.coctailexample.R
import hu.bme.coctailexample.injector
import hu.bme.coctailexample.model.Item
import hu.bme.coctailexample.ui.utils.hide
import hu.bme.coctailexample.ui.utils.show
import kotlinx.android.synthetic.main.fragment_coctails.*
import javax.inject.Inject

class CoctailsFragment : Fragment(), CoctailsScreen {

    private val displayedArtists: MutableList<Item> = mutableListOf()
    private var artistsAdapter: CoctailsAdapter? = null
    private val artist by lazy { arguments!!.getString(KEY_ARTIST)!! }
    private var selectedArtist: String? = null

    @Inject
    lateinit var artistsPresenter: CoctailsPresenter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        artistsPresenter.attachScreen(this)
    }

    override fun onDetach() {
        artistsPresenter.detachScreen()
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_coctails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedArtist = artist
        etArtist.setText(selectedArtist!!)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewArtists.layoutManager = llm

        artistsAdapter = CoctailsAdapter(context!!, displayedArtists)
        recyclerViewArtists.adapter = artistsAdapter

        swipeRefreshLayoutArtists.setOnRefreshListener {
            selectedArtist = etArtist.text.toString()
            artistsPresenter.refreshArtists(selectedArtist!!)
        }
    }

    override fun onResume() {
        super.onResume()
        artistsPresenter.refreshArtists(selectedArtist!!)
    }

    override fun showArtists(artists: List<Item>?) {
        swipeRefreshLayoutArtists.isRefreshing = false
        displayedArtists.clear()
        if (artists != null) {
            displayedArtists.addAll(artists)
        }
        artistsAdapter?.notifyDataSetChanged()

        if (displayedArtists.isEmpty()) {
            recyclerViewArtists.hide()
            tvEmpty.show()
        } else {
            recyclerViewArtists.show()
            tvEmpty.hide()
        }

    }

    override fun showNetworkError(errorMsg: String) {
        swipeRefreshLayoutArtists.isRefreshing = false
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val KEY_ARTIST = "KEY_ARTIST"

        fun newInstance(artist: String): CoctailsFragment {
            val fragment = CoctailsFragment()
            val bundle = Bundle()

            bundle.putString(KEY_ARTIST, artist)
            fragment.arguments = bundle
            return fragment
        }
    }
}
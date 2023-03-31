/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.superheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.marvel.presentation.R
import com.marvel.presentation.databinding.FragmentSuperheroesListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuperheroesListFragment : Fragment() {

    private var _binding: FragmentSuperheroesListBinding? = null
    private val binding get() = _binding!!

    private val superheroesListViewModel: SuperheroesListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val superheroesListLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerSuperheroes.layoutManager = superheroesListLayoutManager
        val superheroesListAdapter = SuperheroesListAdapter(
            onClick = { superhero ->
                val bundle = Bundle()
                bundle.putParcelable("superhero", superhero)
                findNavController().navigate(R.id.action_SuperheroesListFragment_to_SuperheroDetailsFragment, bundle)
            }
        )
        binding.recyclerSuperheroes.adapter = superheroesListAdapter

        binding.swipeRefreshSuperheroes.setOnRefreshListener {
            superheroesListViewModel.refreshSuperheroes()

            // IMPORTANT: This is UGLY! But until use case result is improved we need to do this
            binding.swipeRefreshSuperheroes.isRefreshing = false
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                superheroesListViewModel.superheroesList.collect { refreshedSuperheroes ->
                    binding.swipeRefreshSuperheroes.isRefreshing = false
                    superheroesListAdapter.setData(refreshedSuperheroes)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

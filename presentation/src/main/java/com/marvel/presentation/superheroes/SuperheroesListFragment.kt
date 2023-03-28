/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.superheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.marvel.presentation.R
import com.marvel.presentation.databinding.FragmentSuperheroesListBinding

class SuperheroesListFragment : Fragment() {

    private var _binding: FragmentSuperheroesListBinding? = null
    private val binding get() = _binding!!

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
            onClick = { findNavController().navigate(R.id.action_SuperheroesListFragment_to_SuperheroDetailsFragment) }
        )
        binding.recyclerSuperheroes.adapter = superheroesListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

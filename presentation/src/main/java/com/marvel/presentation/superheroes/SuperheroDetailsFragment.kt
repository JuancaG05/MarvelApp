/**
 * @author Juan Carlos Garrote Gascón, 2023
 */

package com.marvel.presentation.superheroes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.marvel.domain.superheroes.model.Superhero
import com.marvel.presentation.databinding.FragmentSuperheroDetailsBinding

class SuperheroDetailsFragment : Fragment() {

    private var _binding: FragmentSuperheroDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuperheroDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val superhero: Superhero? = arguments?.getParcelable("superhero")
        binding.apply {
            superheroDetailsName.text = superhero?.name
            superheroDetailsImage.load(superhero?.imageUrl)
            superheroDetailsDescription.text = superhero?.description
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

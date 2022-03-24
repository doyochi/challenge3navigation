package id.hikmah.binar.challenge3navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import id.hikmah.binar.challenge3navigation.SecondFragment.Companion.EXTRA_NAME
import id.hikmah.binar.challenge3navigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.getString("extra_name")
        binding.btnFragmentKetiga.setOnClickListener{
            val bundle = Bundle()
            val name = binding.editNama.text.toString()
            bundle.putString(EXTRA_NAME, name)

            it.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}
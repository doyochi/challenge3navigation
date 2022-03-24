package id.hikmah.binar.challenge3navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import id.hikmah.binar.challenge3navigation.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()

        binding.btnFragmentKeEmpat.setOnClickListener{
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }
    }

    private fun getData(){
        val data = arguments?.getString(SecondFragment.EXTRA_NAME)
        binding.viewNama.text = data
    }

}
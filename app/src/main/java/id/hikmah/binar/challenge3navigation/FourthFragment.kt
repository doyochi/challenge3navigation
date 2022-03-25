package id.hikmah.binar.challenge3navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import id.hikmah.binar.challenge3navigation.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFragmentKetiga.setOnClickListener{
            val dataUsia = binding.editUsia.text.toString().toInt()
            val dataAlamat = binding.editAlamat.text.toString()
            val dataPekerjaan = binding.editPekerjaan.text.toString()
            sendToThird(dataUsia, dataAlamat, dataPekerjaan, it)
        }

    }

    private fun sendToThird(valueEditUsia: Int, valueEditAlamat: String, valueEditPekerjaan: String, it: View){

        val dataDiri = DataDiri(valueEditUsia, valueEditAlamat, valueEditPekerjaan)
        val bundle = Bundle()
        //Pakai Bundle
//        bundle.apply {
//            putInt(EXTRA_USIA, valueEditUsia)
//            putString(EXTRA_ALAMAT, valueEditAlamat)
//            putString(EXTRA_PEKERJAAN, valueEditPekerjaan)
//        }

        //Pakai parcleable
        bundle.putParcelable(EXTRA_DATADIRI, dataDiri)
        setFragmentResult("reqKey", bundle)
        it.findNavController().popBackStack()
    }

    companion object{
        const val EXTRA_USIA = "extra_usia"
        const val EXTRA_ALAMAT = "extra_alamat"
        const val EXTRA_PEKERJAAN = "extra pekerjaan"
        const val EXTRA_DATADIRI = "extra_datadiri"
    }
}
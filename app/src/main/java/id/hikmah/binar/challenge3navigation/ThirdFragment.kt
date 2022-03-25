package id.hikmah.binar.challenge3navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import id.hikmah.binar.challenge3navigation.FourthFragment.Companion.EXTRA_ALAMAT
import id.hikmah.binar.challenge3navigation.FourthFragment.Companion.EXTRA_DATADIRI
import id.hikmah.binar.challenge3navigation.FourthFragment.Companion.EXTRA_PEKERJAAN
import id.hikmah.binar.challenge3navigation.FourthFragment.Companion.EXTRA_USIA
import id.hikmah.binar.challenge3navigation.databinding.FragmentThirdBinding
import kotlinx.parcelize.Parcelize

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("reqKey"){ _, bundle ->
            //Pakai Parcelable
            val result = bundle.getParcelable<DataDiri>(EXTRA_DATADIRI)
            val result_usia = result?.usia.toString().toInt()
            val ganEp = getGanEp(result_usia)
            val result_alamat = result?.alamat.toString()
            val result_pekerjaan = result?.pekerjaan.toString()

            // Pakai bundle
//            val result_usia = bundle.getInt(EXTRA_USIA).toString().toInt()
//            val ganEp = getGanEp(result_usia)
//            val result_alamat = bundle.getString(EXTRA_ALAMAT)
//            val result_pekerjaan = bundle.getString(EXTRA_PEKERJAAN)
            binding.apply{
                viewUsia.visibility = View.VISIBLE
                viewUsia.text = "Usia Anda " + result_usia + ", bernilai " + ganEp
                viewAlamat.visibility = View.VISIBLE
                viewAlamat.text = "Alamat Anda " + result_alamat
                viewPekerjaan.visibility = View.VISIBLE
                viewPekerjaan.text = "Pekerjaan Anda " + result_pekerjaan
            }
        }
    }
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
        getNama()

        binding.btnFragmentKeEmpat.setOnClickListener{
            it.findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
        }
    }

    private fun getNama(){
        val nama = arguments?.getString(SecondFragment.EXTRA_NAME)
        binding.viewNama.text = "Nama Anda " + nama
    }

    private fun getGanEp(value: Int): String{
        if (value%2 == 0){
            return "Ganjil"
        } else {
            return "Genap"
        }
    }


}
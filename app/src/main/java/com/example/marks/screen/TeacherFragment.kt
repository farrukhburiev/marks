package com.example.marks.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marks.R
import com.example.marks.adapter.AdapterStudent
import com.example.marks.database.AppDatabase
import com.example.marks.databinding.FragmentTeacherBinding
import com.example.marks.entity.Student
import com.example.marks.entity.Teacher

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TeacherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeacherFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTeacherBinding.inflate(inflater,container,false)
        binding.nameTeacher.text = param1


//        var teachers:List<Teacher> = appDatabase.getUserDao().getAllTeachers()
        var students:List<Student> = appDatabase.getUserDao().getAllStudents()
        val adapter = AdapterStudent(students,object :AdapterStudent.ItemClick{
            override fun OnItemClick(position: Int) {
                TODO("Not yet implemented")
            }

        })
//
        binding.studentList.adapter = adapter
        var layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.studentList.layoutManager = layoutManager

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TeacherFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            TeacherFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
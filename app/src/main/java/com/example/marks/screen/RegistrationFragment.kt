package com.example.marks.screen

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.marks.R
import com.example.marks.database.AppDatabase
import com.example.marks.databinding.FragmentRegistrationBinding
import com.example.marks.entity.Student
import com.example.marks.model.Subject
import com.example.marks.entity.Teacher
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
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
        val binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        var subjects = ArrayList<Subject>()
        subjects.add(Subject.ALGEBRA)
        subjects.add(Subject.GEOMETRIYA)
        subjects.add(Subject.INFORMATIKA)
        subjects.add(Subject.FIZIKA)
        subjects.add(Subject.INGLIZTILI)
        subjects.add(Subject.ONATILI)
        subjects.add(Subject.ADABIYOT)

        var subject:Subject = Subject.ALGEBRA

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,subjects)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.subjectSpinner.adapter = adapter

        binding.subjectSpinner.onItemSelectedListener = (object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                subject = subjects[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        })
        binding.subjectSpinner.visibility = View.GONE
        binding.status.setOnClickListener{
            if (!binding.status.isChecked){
                binding.subjectSpinner.visibility = View.GONE
            }
            else  binding.subjectSpinner.visibility = View.VISIBLE

        }

        binding.save.setOnClickListener {
            if (binding.nameOrg.text.isNullOrEmpty() || binding.passwordOrg.text.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "fill the blanks", Toast.LENGTH_SHORT).show()
            } else {
                if (!binding.status.isChecked) {
                    appDatabase.getUserDao().addStudent(
                        Student(
                            password_student = binding.passwordOrg.text.toString(),
                            name_student = binding.nameOrg.text.toString()
                        )
                    )
                } else {
                    appDatabase.getUserDao().addTeacher(
                        Teacher(
                            password_teacher = binding.passwordOrg.text.toString(),
                            name_teacher = binding.nameOrg.text.toString(),
                            subject = subject
                        )
                    )
                }
                var teachers:List<Teacher> = appDatabase.getUserDao().getAllTeachers()
                var students:List<Student> = appDatabase.getUserDao().getAllStudents()

                Log.d("FGHJ", "onCreateView: "+students.joinToString())
                if (teachers.size == 0 && students.size == 0){
                    Toast.makeText(requireContext(), "couldn't save your data", Toast.LENGTH_SHORT).show()
                    binding.nameOrg.setText("")
                    binding.passwordOrg.setText("")
                    binding.nameOrg.requestFocus()
                }
                else parentFragmentManager.beginTransaction().replace(R.id.main_activity,LoginFragment()).commit()
            }
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
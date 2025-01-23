package com.example.islamy_native

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy_native.databinding.SebhaBinding

class ShebaFragment : Fragment() {
    private lateinit var binding: SebhaBinding
    private lateinit var azkarList: List<String>
    private var rotationAngle = 0f
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        azkarList = resources.getStringArray(R.array.azkar_list).toList()

        initView()
    }

    private fun initView() {

        binding.sebha1.setOnClickListener {
            rotateImage()
            incrementCounter()
        }

        // Initialize the counter display
        updateCounterDisplay()
        updateAzkarMessage()
    }

    private fun rotateImage() {
        // Increase the rotation angle
        rotationAngle += 30f
        binding.sebha1.rotation = rotationAngle
    }

    private fun incrementCounter() {
        // Increment the counter and reset if it exceeds 132
        counter = if (counter == 132) 1 else counter + 1
        updateCounterDisplay()
        updateAzkarMessage()
    }

    private fun updateCounterDisplay() {
        // Update the counter text view
        binding.num.text = counter.toString()
    }

    private fun updateAzkarMessage() {
        // Determine the Azkar message based on the counter value
        val azkarMessage = when {
            counter in 1..33 -> azkarList.getOrNull(0) ?: "سبحان الله" // Default if list is empty
            counter in 34..66 -> azkarList.getOrNull(1) ?: "الحمد لله"
            counter in 67..99 -> azkarList.getOrNull(2) ?: "لا إله إلا الله"
            counter in 100..132 -> azkarList.getOrNull(3) ?: "الله أكبر"
            else -> ""
        }
        binding.sebhaText.text = azkarMessage
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

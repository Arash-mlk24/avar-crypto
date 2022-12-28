package ir.avarsaji.crypto.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ir.avarsaji.crypto.databinding.ActivityMainBinding
import ir.avarsaji.crypto.viewmodel.ActivityMainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ActivityMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()
        observeItems()
        setEvents()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun observeItems() {
        viewModel.getErrorMessageObserver().observe(this) {
            Toast.makeText(
                this,
                it,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setEvents() {
        binding.usaEdtText.addTextChangedListener(InputTextWatcher(viewModel, "usa"))
        binding.englandEdtText.addTextChangedListener(InputTextWatcher(viewModel, "england"))
        binding.emiratesEdtText.addTextChangedListener(InputTextWatcher(viewModel, "emirates"))
        binding.canadaEdtText.addTextChangedListener(InputTextWatcher(viewModel, "canada"))
        binding.iranEdtText.addTextChangedListener(InputTextWatcher(viewModel, "iran"))
        binding.euroEdtText.addTextChangedListener(InputTextWatcher(viewModel, "euro"))

        viewModel.getUsaTextObserver().observe(this) {
            if (binding.usaEdtText.isFocused) {
                binding.emiratesEdtText.setText(if (it == "") "" else (it.toDouble() * 3.6701).toString())
                binding.canadaEdtText.setText(if (it == "") "" else (it.toDouble() * 1.3434).toString())
                binding.englandEdtText.setText(if (it == "") "" else (it.toDouble() * 0.8157).toString())
                binding.iranEdtText.setText(if (it == "") "" else (it.toDouble() * 42423.2432).toString())
                binding.euroEdtText.setText(if (it == "") "" else (it.toDouble() * 0.9499).toString())
            }
        }

        viewModel.getCanadaTextObserver().observe(this) {
            if (binding.canadaEdtText.isFocused) {
                binding.emiratesEdtText.setText(if (it == "") "" else (it.toDouble() / 1.3434 * 3.6701).toString())
                binding.usaEdtText.setText(if (it == "") "" else (it.toDouble() / 1.3434).toString())
                binding.englandEdtText.setText(if (it == "") "" else (it.toDouble() / 1.3434 * 0.8157).toString())
                binding.iranEdtText.setText(if (it == "") "" else (it.toDouble() / 1.3434 * 42423.2432).toString())
                binding.euroEdtText.setText(if (it == "") "" else (it.toDouble() / 1.3434 * 0.9499).toString())
            }
        }

        viewModel.getEnglandTextObserver().observe(this) {
            if (binding.englandEdtText.isFocused) {
                binding.emiratesEdtText.setText(if (it == "") "" else (it.toDouble() / 0.8157 * 3.6701).toString())
                binding.canadaEdtText.setText(if (it == "") "" else (it.toDouble() / 0.8157 * 1.3434).toString())
                binding.usaEdtText.setText(if (it == "") "" else (it.toDouble() / 0.8157).toString())
                binding.iranEdtText.setText(if (it == "") "" else (it.toDouble() / 0.8157 * 42423.2432).toString())
                binding.euroEdtText.setText(if (it == "") "" else (it.toDouble() / 0.8157 * 0.9499).toString())
            }
        }

        viewModel.getEmiratesTextObserver().observe(this) {
            if (binding.emiratesEdtText.isFocused) {
                binding.usaEdtText.setText(if (it == "") "" else (it.toDouble() / 3.6701).toString())
                binding.canadaEdtText.setText(if (it == "") "" else (it.toDouble() / 3.6701 * 1.3434).toString())
                binding.englandEdtText.setText(if (it == "") "" else (it.toDouble() / 3.6701 * 0.8157).toString())
                binding.iranEdtText.setText(if (it == "") "" else (it.toDouble() / 3.6701 * 42423.2432).toString())
                binding.euroEdtText.setText(if (it == "") "" else (it.toDouble() / 3.6701 * 0.9499).toString())
            }
        }

        viewModel.getIranTextObserver().observe(this) {
            if (binding.iranEdtText.isFocused) {
                binding.usaEdtText.setText(if (it == "") "" else (it.toDouble() / 42423.2432).toString())
                binding.canadaEdtText.setText(if (it == "") "" else (it.toDouble() / 42423.2432 * 1.3434).toString())
                binding.englandEdtText.setText(if (it == "") "" else (it.toDouble() / 42423.2432 * 0.8157).toString())
                binding.emiratesEdtText.setText(if (it == "") "" else (it.toDouble() / 42423.2432 * 3.6701).toString())
                binding.euroEdtText.setText(if (it == "") "" else (it.toDouble() / 42423.2432 * 0.9499).toString())
            }
        }

        viewModel.getEuroTextObserver().observe(this) {
            if (binding.euroEdtText.isFocused) {
                binding.usaEdtText.setText(if (it == "") "" else (it.toDouble() / 0.9499).toString())
                binding.canadaEdtText.setText(if (it == "") "" else (it.toDouble() / 0.9499 * 1.3434).toString())
                binding.englandEdtText.setText(if (it == "") "" else (it.toDouble() / 0.9499 * 0.8157).toString())
                binding.iranEdtText.setText(if (it == "") "" else (it.toDouble() / 0.9499 * 42423.2432).toString())
                binding.emiratesEdtText.setText(if (it == "") "" else (it.toDouble() / 0.9499 * 3.6701).toString())
            }
        }
    }
}

private class InputTextWatcher(
    private val viewModel: ActivityMainViewModel,
    private val strategy: String
) : TextWatcher {
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun afterTextChanged(p0: Editable?) {
        when (strategy) {
            "usa" -> viewModel.setUsaText(p0.toString())
            "emirates" -> viewModel.setEmiratesText(p0.toString())
            "england" -> viewModel.setEnglandText(p0.toString())
            "canada" -> viewModel.setCanadaText(p0.toString())
            "iran" -> viewModel.setIranText(p0.toString())
            "euro" -> viewModel.setEuroText(p0.toString())
        }
    }
}
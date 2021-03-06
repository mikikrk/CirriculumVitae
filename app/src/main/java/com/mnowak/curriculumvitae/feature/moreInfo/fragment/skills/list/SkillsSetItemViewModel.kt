package com.mnowak.curriculumvitae.feature.moreInfo.fragment.skills.list

import android.graphics.Color
import androidx.lifecycle.LiveData
import com.mnowak.curriculumvitae.data.model.SkillsSet
import com.mnowak.curriculumvitae.liveData.InitializedLiveData

abstract class SkillsSetItemViewModel {

    abstract val id: LiveData<Int>
    abstract val label: LiveData<String>
    abstract val labelColor: LiveData<Int>
    abstract val skills: LiveData<List<SkillItemViewModel>>

    abstract class SkillItemViewModel {

        abstract val name: LiveData<String>
        abstract val skillLevel: LiveData<SkillLevel>

        enum class SkillLevel {
            GOOD, MEDIUM, LOW;
        }
    }
}

class SkillsSetItemViewModelImpl(

        private val skillsSet: SkillsSet

) : SkillsSetItemViewModel() {

    override val id = InitializedLiveData(skillsSet.id)
    override val label = InitializedLiveData(skillsSet.label)
    override val labelColor = InitializedLiveData(Color.parseColor(skillsSet.labelColor))

    private val goodSkillsList = skillsSet.goodLevelSkills?.map {
        SkillItemViewModelImpl(it, SkillItemViewModel.SkillLevel.GOOD) as SkillItemViewModel
    } ?: emptyList()
    private val mediumSkillsList = skillsSet.mediumLevelSkills?.map {
        SkillItemViewModelImpl(it, SkillItemViewModel.SkillLevel.MEDIUM) as SkillItemViewModel
    } ?: emptyList()
    private val lowSkillsList = skillsSet.lowLevelSkills?.map {
        SkillItemViewModelImpl(it, SkillItemViewModel.SkillLevel.LOW) as SkillItemViewModel
    } ?: emptyList()
    override val skills = InitializedLiveData(goodSkillsList + mediumSkillsList + lowSkillsList)

    class SkillItemViewModelImpl(

            name: String,
            skillLevel: SkillLevel

    ) : SkillItemViewModel() {

        override val name = InitializedLiveData(name)
        override val skillLevel = InitializedLiveData(skillLevel)
    }

    override fun equals(other: Any?): Boolean =
            if (other is SkillsSetItemViewModelImpl) {
                this.skillsSet == other.skillsSet
            } else {
                super.equals(other)

            }

    override fun hashCode(): Int {
        return skillsSet.hashCode()
    }
}

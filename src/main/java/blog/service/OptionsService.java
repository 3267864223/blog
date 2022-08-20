package blog.service;

import java.util.List;

import blog.entity.Options;

public interface OptionsService {

	/**
	 * 查询全部选项
	 * @return 选项信息列表
	 */
	List<Options> getAllOptions();

	/**
	 * 根据optionId查询选项
	 * @return 选项信息
	 */
	Options getOptionsById(Integer optionsId);

	/**
	 * 修改选项
	 * @param 选项信息
	 */
	void updateOptions(Options options);

}

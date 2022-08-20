package blog.mapper;

import java.util.List;

import blog.entity.Options;

public interface OptionsMapper {

	/**
	 * 查询全部选项
	 * @return 选项信息列表
	 */
	List<Options> getAllOptions();

	/**
	 * 根据optionsId查询选项
	 * @return 选项信息
	 */
	Options getOptionsById(Integer optionsId);

	/**
	 * 更新选项（无修改图片）
	 * @param 选项信息
	 */
	void updateOptions(Options options);

	/**
	 * 更新选项（两张图片都修改）
	 * @param 选项信息
	 */
	void updateOptionsP2(Options options);

	/**
	 * 更新选项（修改微信图片）
	 * @param 选项信息
	 */
	void updateOptionsPv(Options options);

	/**
	 * 更新选项（修改头像图片）
	 * @param 选项信息
	 */
	void updateOptionsPa(Options options);

}

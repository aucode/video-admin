package com.video.system.domain;

import com.video.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project ruoyi
 * @Description: SysRotationChart
 * @Author Du Yi Code
 * @Explain
 * @Date 2020-08-30 22:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRotationChart extends BaseEntity {
    private Integer rotationchartid;
    private String url;
}

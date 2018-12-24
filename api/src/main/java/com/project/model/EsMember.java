package com.project.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "es_member")
public class EsMember {
    @Id
    @Column(name = "member_id")
    private Integer memberId;

    private Integer agentid;

    private Integer parentid;

    @Column(name = "lv_id")
    private Integer lvId;

    private String uname;

    private String email;

    private String password;

    private Long regtime;

    private String name;

    private Integer sex;

    private Long birthday;

    private BigDecimal advance;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "town_id")
    private Integer townId;

    private String province;

    private String city;

    private String region;

    private String town;

    private String address;

    private String zip;

    private String mobile;

    private String tel;

    private Integer point;

    private Integer mp;

    @Column(name = "QQ")
    private String qq;

    private String msn;

    private Long lastlogin;

    @Column(name = "is_agent")
    private Integer isAgent;

    private Integer logincount;

    @Column(name = "is_cheked")
    private Integer isCheked;

    private String registerip;

    @Column(name = "recommend_point_state")
    private Integer recommendPointState;

    @Column(name = "last_send_email")
    private Integer lastSendEmail;

    @Column(name = "info_full")
    private Integer infoFull;

    @Column(name = "find_code")
    private String findCode;

    private String face;

    private String nickname;

    private Integer midentity;

    private Short disabled;

    private String remark;

    /**
     * @return member_id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * @return agentid
     */
    public Integer getAgentid() {
        return agentid;
    }

    /**
     * @param agentid
     */
    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }

    /**
     * @return parentid
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return lv_id
     */
    public Integer getLvId() {
        return lvId;
    }

    /**
     * @param lvId
     */
    public void setLvId(Integer lvId) {
        this.lvId = lvId;
    }

    /**
     * @return uname
     */
    public String getUname() {
        return uname;
    }

    /**
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return regtime
     */
    public Long getRegtime() {
        return regtime;
    }

    /**
     * @param regtime
     */
    public void setRegtime(Long regtime) {
        this.regtime = regtime;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return birthday
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    /**
     * @return advance
     */
    public BigDecimal getAdvance() {
        return advance;
    }

    /**
     * @param advance
     */
    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    /**
     * @return province_id
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return city_id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * @param cityId
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * @return region_id
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * @param regionId
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * @return town_id
     */
    public Integer getTownId() {
        return townId;
    }

    /**
     * @param townId
     */
    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return town
     */
    public String getTown() {
        return town;
    }

    /**
     * @param town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return point
     */
    public Integer getPoint() {
        return point;
    }

    /**
     * @param point
     */
    public void setPoint(Integer point) {
        this.point = point;
    }

    /**
     * @return mp
     */
    public Integer getMp() {
        return mp;
    }

    /**
     * @param mp
     */
    public void setMp(Integer mp) {
        this.mp = mp;
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return msn
     */
    public String getMsn() {
        return msn;
    }

    /**
     * @param msn
     */
    public void setMsn(String msn) {
        this.msn = msn;
    }

    /**
     * @return lastlogin
     */
    public Long getLastlogin() {
        return lastlogin;
    }

    /**
     * @param lastlogin
     */
    public void setLastlogin(Long lastlogin) {
        this.lastlogin = lastlogin;
    }

    /**
     * @return is_agent
     */
    public Integer getIsAgent() {
        return isAgent;
    }

    /**
     * @param isAgent
     */
    public void setIsAgent(Integer isAgent) {
        this.isAgent = isAgent;
    }

    /**
     * @return logincount
     */
    public Integer getLogincount() {
        return logincount;
    }

    /**
     * @param logincount
     */
    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    /**
     * @return is_cheked
     */
    public Integer getIsCheked() {
        return isCheked;
    }

    /**
     * @param isCheked
     */
    public void setIsCheked(Integer isCheked) {
        this.isCheked = isCheked;
    }

    /**
     * @return registerip
     */
    public String getRegisterip() {
        return registerip;
    }

    /**
     * @param registerip
     */
    public void setRegisterip(String registerip) {
        this.registerip = registerip;
    }

    /**
     * @return recommend_point_state
     */
    public Integer getRecommendPointState() {
        return recommendPointState;
    }

    /**
     * @param recommendPointState
     */
    public void setRecommendPointState(Integer recommendPointState) {
        this.recommendPointState = recommendPointState;
    }

    /**
     * @return last_send_email
     */
    public Integer getLastSendEmail() {
        return lastSendEmail;
    }

    /**
     * @param lastSendEmail
     */
    public void setLastSendEmail(Integer lastSendEmail) {
        this.lastSendEmail = lastSendEmail;
    }

    /**
     * @return info_full
     */
    public Integer getInfoFull() {
        return infoFull;
    }

    /**
     * @param infoFull
     */
    public void setInfoFull(Integer infoFull) {
        this.infoFull = infoFull;
    }

    /**
     * @return find_code
     */
    public String getFindCode() {
        return findCode;
    }

    /**
     * @param findCode
     */
    public void setFindCode(String findCode) {
        this.findCode = findCode;
    }

    /**
     * @return face
     */
    public String getFace() {
        return face;
    }

    /**
     * @param face
     */
    public void setFace(String face) {
        this.face = face;
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return midentity
     */
    public Integer getMidentity() {
        return midentity;
    }

    /**
     * @param midentity
     */
    public void setMidentity(Integer midentity) {
        this.midentity = midentity;
    }

    /**
     * @return disabled
     */
    public Short getDisabled() {
        return disabled;
    }

    /**
     * @param disabled
     */
    public void setDisabled(Short disabled) {
        this.disabled = disabled;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}